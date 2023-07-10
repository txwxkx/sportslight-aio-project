import pandas as pd
import logging
import cx_Oracle

logging.basicConfig(filename="error.log", level=logging.DEBUG)  # 에러 기록하기
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from flask import Flask  # 플라스크 서버 만들기


app = Flask(__name__)


# 초기화면
@app.route("/")
def hello():
    return "페이지 로드 완료"


# searchNum 에 따라 맞는 결과 리턴
@app.route("/<searchNum>")
def index(searchNum):
    print("함수 시작")

    # python과 오라클 연결
    conn = cx_Oracle.connect("hr", "a1234", "localhost:1521/xe")

    # 모든 데이터가 출력 되로록 설정
    pd.set_option("display.max_rows", None)  # 행
    pd.set_option("display.max_columns", None)  # 열

    # Conn으로부터 Cursor 생성
    curs = conn.cursor()

    # sql문 실행
    sql = "SELECT videoNum, videoName FROM video ORDER BY videoNum DESC"
    curs.execute(sql)

    # 데이터프레임으로 변환
    col_names = [row[0] for row in curs.description]
    data = pd.DataFrame(curs.fetchall(), columns=col_names)
    print(data.iloc[:, 1])

    # 연결 종료
    curs.close()  # 커서
    conn.close()  # 연결

    # 코사인 유사도 분석
    tfidf = TfidfVectorizer(stop_words="english")

    # 제목만 있는 부분을 추출
    tfidf_matrix = tfidf.fit_transform(data.iloc[:, 1])

    print("TF-IDF 행렬의 크기(shape) :", tfidf_matrix.shape)

    cosine_sim = cosine_similarity(tfidf_matrix, tfidf_matrix)
    print("코사인 유사도 연산 결과 :", cosine_sim.shape)

    # 영상 추천 과정 함수
    def get_recommendations(searchNum, cosine_sim=cosine_sim):
        # 선택한 영상의 타이틀로부터 해당 인덱스를 받아온다.
        idx = searchNum

        # 해당 영상과 모든 영상과의 유사도를 가져온다.
        sim_scores = list(enumerate(cosine_sim[idx]))

        # 유사도에 따라 영상들을 정렬한다.
        sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)

        # 가장 유사한 10개의 영상를 받아온다.
        sim_scores = sim_scores[1:11]

        # 가장 유사한 10개의 영상의 인덱스를 얻는다.
        video_indices = [idx[0] for idx in sim_scores]

        # 영상 인덱스를 리턴한다.
        return video_indices

    return get_recommendations(int(searchNum))

if __name__ == "__main__":
    app.run(debug=True)
