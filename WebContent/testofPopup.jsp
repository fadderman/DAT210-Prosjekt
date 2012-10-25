<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	//Popup window code
	function newWindow(url) {
		popupWindow = window
				.open(
						url,
						'popUpWindow',
						'height=800,width=1050,left=100,top=100,resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no,status=yes')
	}

	function closeWindow() {
		if (false == popupWindow.closed) {
			popupWindow.close();
		} else {
			alert('That window is already closed. Open the window first and try again!');
		}
	}
</script>
<body>
<button onClick="JavaScript:newWindow('TraineeSeekingMentor.jsp')">Open Popup Window</button>
<button onClick="JavaScript:closeWindow();">Close Popup Window</button>
</body>
</html>