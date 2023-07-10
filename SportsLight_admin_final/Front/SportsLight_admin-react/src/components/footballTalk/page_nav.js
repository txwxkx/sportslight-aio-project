import { useSelector } from "react-redux";

const PageNavigation = ({ getFootballTalkList }) => {
  const pv = useSelector((state) =>
    state.footballTalk.pv ? state.footballTalk.pv : { currentPage: 1 }
  );

  const pageNumbers = [];
  for (let i = pv.startPage; i <= pv.endPage; i++) {
    pageNumbers.push(i); // 페이지에 대한 정보 저장
  }

  return (
    <nav arial-label="Page navigation example">
      <ul className="pagination justify-content-center">
        <li className={pv.startPage <= 1 ? "page-item disabled" : "page-item"}>
          <span
            className="page-link"
            onClick={() => getFootballTalkList(pv.startPage - pv.blockPage)}
          >
            &laquo;
          </span>
        </li>

        {pageNumbers.map((pnum, idx) => (
          <li
            key={pnum}
            className={pv.currentPage === pnum ? "page-item active" : null}
            aria-current={pv.currentPage === pnum ? "page" : null}
          >
            <span
              className="page-link"
              onClick={() => getFootballTalkList(pnum)}
            >
              {pnum}
            </span>
          </li>
        ))}

        <li
          className={
            pv.endPage >= pv.totalPage ? "page-item disabled" : "page-item"
          }
        >
          <span
            className="page-link"
            onClick={() => getFootballTalkList(pv.startPage + pv.blockPage)}
          >
            &raquo;
          </span>
        </li>
      </ul>
    </nav>
  );
};

export default PageNavigation;
