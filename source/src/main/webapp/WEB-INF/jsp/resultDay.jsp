<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>本日の評価</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/resultDay.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- ヘッダー -->
    <div class="headerH2">
        <h2>本日の評価</h2>
    </div>   

    <!-- 目標時間表示 -->
    <div class="goalTimeContainer">
        <h1>本日の活動</h1>
        <!-- 運動時間 -->
        <div class="goalTimeItem">
            <div class="icon">
                <svg width="25" height="25" viewBox="0 0 19 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M12.25 6.25C13.9069 6.25 15.25 4.90685 15.25 3.25C15.25 1.59315 13.9069 0.25 12.25 0.25C10.5931 0.25 9.25 1.59315 9.25 3.25C9.25 4.90685 10.5931 6.25 12.25 6.25ZM12.25 1.75C13.0784 1.75 13.75 2.42157 13.75 3.25C13.75 4.07843 13.0784 4.75 12.25 4.75C11.4216 4.75 10.75 4.07843 10.75 3.25C10.75 2.42157 11.4216 1.75 12.25 1.75ZM18.5603 11.1888C18.5031 11.215 17.8581 11.4963 16.7162 11.4963C15.4178 11.4963 13.4772 11.1325 11.0266 9.62125C10.6536 10.6801 10.1693 11.6964 9.58187 12.6531C10.637 12.9779 11.6294 13.4791 12.5172 14.1353C14.305 15.4984 15.25 17.4391 15.25 19.75C15.25 20.1642 14.9142 20.5 14.5 20.5C14.0858 20.5 13.75 20.1642 13.75 19.75C13.75 15.8406 10.4978 14.4334 8.67437 13.9516C8.62281 14.0172 8.56938 14.0837 8.51594 14.1484C6.67469 16.3797 4.3675 17.5403 1.80063 17.5403C1.50826 17.5417 1.21601 17.5282 0.925 17.5C0.510786 17.4586 0.208579 17.0892 0.25 16.675C0.291421 16.2608 0.660786 15.9586 1.075 16C3.505 16.2419 5.61906 15.2978 7.35625 13.1875C8.52719 11.7681 9.325 10.0366 9.72344 8.78125C6.07469 6.65781 3.74406 8.46531 3.71875 8.485C3.51073 8.66263 3.22251 8.71292 2.96663 8.61623C2.71075 8.51955 2.5278 8.29123 2.48922 8.02042C2.45064 7.74962 2.56255 7.47929 2.78125 7.315C2.92188 7.2025 6.27063 4.59625 11.1728 7.93094C15.4356 10.8288 17.9163 9.835 17.9397 9.82375C18.1842 9.70827 18.472 9.73337 18.6928 9.88946C18.9137 10.0455 19.0334 10.3084 19.0061 10.5775C18.9789 10.8466 18.8089 11.0801 18.5613 11.1888H18.5603Z" fill="#0F1417"/>
                </svg>
            </div>
            <div class="goalTimeText"><p>運動時間</p><span><fmt:formatNumber value="${extime}"
						maxFractionDigits="1" groupingUsed="false" />時間</span></div>
        </div>
        <!-- 勉強時間 -->
        <div class="goalTimeItem">
            <div class="icon">
                <svg width="25" height="25" viewBox="0 0 22 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M20 0.5H14C12.8197 0.5 11.7082 1.05573 11 2C10.2918 1.05573 9.18034 0.5 8 0.5H2C1.17157 0.5 0.5 1.17157 0.5 2V14C0.5 14.8284 1.17157 15.5 2 15.5H8C9.24264 15.5 10.25 16.5074 10.25 17.75C10.25 18.1642 10.5858 18.5 11 18.5C11.4142 18.5 11.75 18.1642 11.75 17.75C11.75 16.5074 12.7574 15.5 14 15.5H20C20.8284 15.5 21.5 14.8284 21.5 14V2C21.5 1.17157 20.8284 0.5 20 0.5ZM8 14H2V2H8C9.24264 2 10.25 3.00736 10.25 4.25V14.75C9.6015 14.262 8.8116 13.9987 8 14ZM20 14H14C13.1884 13.9987 12.3985 14.262 11.75 14.75V4.25C11.75 3.00736 12.7574 2 14 2H20V14Z" fill="#0D171C"/>
                </svg>
            </div>
            <div class="goalTimeText"><p>勉強時間</p><span><fmt:formatNumber value="${sttime}"
						maxFractionDigits="1" groupingUsed="false" />時間</span></div>
        </div>
        <!-- 睡眠時間 -->
        <div class="goalTimeItem">
            <div class="icon">
                <svg width="25" height="25" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M18.8944 12.3341C18.6983 12.1376 18.4098 12.0655 18.1444 12.1466C15.2305 13.0275 12.0684 12.2338 9.91589 10.0813C7.7634 7.92881 6.96973 4.76665 7.85063 1.85281C7.93239 1.58725 7.86064 1.29825 7.66417 1.10177C7.46769 0.905293 7.17868 0.833543 6.91313 0.915313C4.93596 1.52098 3.20019 2.73481 1.95281 4.38406C-0.272197 7.33813 -0.634332 11.2968 1.01776 14.6055C2.66985 17.9143 6.05173 20.0035 9.75 20C11.8653 20.0065 13.9244 19.3188 15.6112 18.0425C17.2605 16.7951 18.4743 15.0593 19.08 13.0822C19.1608 12.8177 19.0895 12.5301 18.8944 12.3341ZM14.7094 16.8444C11.4249 19.3182 6.82017 18.9958 3.91251 16.0884C1.00484 13.1809 0.68204 8.57623 3.15562 5.29156C3.93507 4.26224 4.94275 3.42786 6.09937 2.85406C6.03349 3.31646 6.00028 3.78293 6 4.25C6.00568 9.63242 10.3676 13.9943 15.75 14C16.218 13.9999 16.6854 13.9666 17.1488 13.9006C16.5744 15.0574 15.7394 16.0651 14.7094 16.8444Z" fill="#0F1417"/>
                </svg>
            </div>
            <div class="goalTimeText"><p>睡眠時間</p><span><fmt:formatNumber value="${sltime}"
						maxFractionDigits="1" groupingUsed="false" />時間</span></div>
        </div>
        <h1>達成率</h1>
    </div>

    <!-- 進捗率表示 -->
    <div class="progressContainer">
        <p>今日の進捗率</p>
        <!-- ここのwidthをjspで変更してください -->
        <div class="progressBar">
            <div class="progressBarFill" style="width: <%= session.getAttribute("level") %>%;"></div>
        </div>
        <p><span><%= session.getAttribute("level") %>%</span></p>
    </div>

    <!-- フィードバック -->
    <div>
        <p><%=session.getAttribute("feedback") %></p>
    </div>

    <!-- フッター -->
    <jsp:include page="footerMenu.jsp" />
</body>
</html>