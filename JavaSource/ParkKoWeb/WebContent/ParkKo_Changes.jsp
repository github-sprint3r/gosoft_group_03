<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Park-Ko Changes</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="dist/css/bootstrap-theme.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="theme.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.table-striped {
	width: 700px;
	align: center;
	border-color: black;
}
</style>
</head>

<body role="document" background="Main_BG.png">
	<div class="container-fluid">

		<form>
			<div class="form-group">
				<table align="center" class="table table-striped">
					<tr>
						<td width="160" height="160" style="background-color: #ff93a9">
							<img src="PA_PUI.jpg" class="img-rounded" width="160"
							height="160">
						</td>
						<td style="background-color: #ff93a9">
							<div align="center">
								<font color="white" size="6">สวัสดี</font>
							</div>
						</td>
					</tr>
					<tr>
						<td style="background-color: white"></td>
						<td style="background-color: white">
							<div class="row">
								<div class="col-md-4">
									<label for="TxTName"><font color="#66CCCC">ชื่อ</font></label>
									<label id="LbName"> <% %>
									</label>
								</div>
								<div class="col-md-4">
									<label for="TxTSurname"><font color="#66CCCC">นามสกุล</font></label>
									<label id="LbSurname"> <% %>
									</label>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td style="background-color: white"></td>
						<td style="background-color: white"><label for="TxTCarID"><font
								color="#66CCCC">ทะเบียนรถ</font></label> <label id="LbCarId"> <% %>
						</label></td>
					</tr>
					<tr>
						<td style="background-color: white"></td>
						<td style="background-color: white"><label for="TxTProvince"><font
								color="#66CCCC">จังหวัด</font></label> <label id="LbProvice"> <% %>
						</label></td>
					</tr>
					<tr>
						<td style="background-color: white"></td>
						<td style="background-color: white"><label for="TxTEntrytime"><font
								color="#66CCCC">วัน เวลาเข้า</font></label> <label id="LbEntrytime">
								<% %>
						</label></td>
					</tr>
					<tr>
						<td style="background-color: white"></td>
						<td style="background-color: white"><label for="TxTExittime"><font
								color="#66CCCC">วัน เวลา ออก</font></label> <label id="LbExittime">
								<% %>
						</label></td>
					</tr>
					<tr>
						<td style="background-color: white">
							<div align="center">
								<label for="TxTPayamountt"><font color="#FF6699">ค่าจอด</font></label>
							</div>
						</td>
						<td style="background-color: white">
							<div align="center">
								<label for="LbPayamountt"> <% %>
								</label> <label><font color="#FF6699">บาท</font></label>
							</div>
						</td>
					</tr>
					<tr>
						<td style="background-color: white">
							<div align="center">
								<label for="TxTRecAmt"><font color="#FF6699">รับเงิน</font></label>
							</div>
						</td>
						<td style="background-color: white">
							<div align="center">
								<label for="LbRecAmt"> <% %>
								</label> <label><font color="#FF6699">บาท</font></label>
							</div>
						</td>
					</tr>
					<tr>
						<td style="background-color: white">
							<div align="center">
								<label for="TxTChanges"><font color="#FF6699">ทอนเงิน</font></label>
							</div>
						</td>
						<td style="background-color: white">
							<div align="center">
								<label for="LbChanges"> <% %>
								</label> <label><font color="#FF6699">บาท</font></label>
							</div>
						</td>
					</tr>

				</table>
			</div>
		</form>
	</div>
</body>
</html>
