package com.dm.spring.common;

public class PageBarFactory {
	
	public static String getPageBar(int cPage, int numPerpage, int totalData, String url) {
		
		String pageBar = "";
		
		/* (전체갯수 / 출력될 데이터 개수) */
		int totalPage = (int)Math.ceil((double)totalData / numPerpage);
		
		/* 페이지 바 사이즈 갯수 */
		int pageBarSize = 5;
		
		/* 페이지 시작페이지 */
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		
		/* 페이지 끝페이지 */
		int pageEnd = pageNo + (pageBarSize - 1);
		
		pageBar = "<ul class='pagination justify-content-center pagination-sm'>";
		
		if(pageNo == 1) {
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a href='#' class='page-link'>이전</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a href='javascript:fn_paging(" + (pageNo - 1) + ")' class='page-link'>이전</a>";
			pageBar += "</li>";
		}
		
		while(!(pageNo > pageEnd || pageNo > totalPage)) {
			/* 지금현재 보고 있는 페이지가 같다면 ? */
			if (cPage == pageNo) {
				pageBar += "<li class='page-item disabled'>";
				pageBar += "<a href='#' class='page-link'>" + pageNo + "</a>";
				pageBar += "</li>";
			} else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a href='javascript:fn_paging(" + pageNo + ")' class='page-link'>" + pageNo + "</a>";
				pageBar += "</li>";
			}
			
			pageNo++;
		}
		
		if (pageNo > totalPage) {
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a href='#' class='page-link'>다음</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a href='javascript:fn_paging(" + pageNo + ")' class='page-link'>다음</a>";
			pageBar += "</li>";
		}
		
		pageBar += "</ul>";
		
		/* 상수 이슈 때문에.. Arrow Function 안쓰는게 나음.. */
		pageBar += "<script>";
		pageBar += "function fn_paging(pageNo){";
		pageBar += "location.assign('" + url + "?cPage=' + pageNo + '&numPerpage=" + numPerpage + "');";
		pageBar += "}";
		pageBar += "</script>";
		
		return pageBar;
	}
}
