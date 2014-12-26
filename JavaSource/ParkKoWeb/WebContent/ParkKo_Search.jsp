<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Park-Ko Search</title>

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
.form-control {
	width: 300px;
}

.table-striped {
	width: 700px;
	align: center;
	border-color: black;
}
.btn-search {
	background-color:#ff93a9;
	color:black;
}
</style>
</head>
<body role="document" style="background-color: #ffcccc">

	<table align="center" class="table table-striped">
		<form class="form-horizontal" action="/web/ParkSearchServlet"
			method="post">
		<tr>
			<td width="160" height="160" style="background-color: #ff93a9">
				<H1 align="center" >Park-Ko</H1>
			</td>
		</tr>

		<tr>
			<td style="background-color: white">

				<div class="form-group">
					<label for="txtCarID" class="col-sm-2 control-label">ทะเบียนรถ</label>
					<div class="col-sm-10">
						<input id="txtCarID" name="txtCarID"  type="text" class="form-control"
							placeholder="กรุณาระบุทะเบียนรถ">
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="background-color: white">
				<div class="form-group">
					<label for="lstProvince" class="col-sm-2 control-label">จังหวัด</label>
					<div class="dropdown col-sm-10">
						<select class="form-control" id="lstProvince" name="lstProvince">
							<option value="111" selected>--------- เลือกจังหวัด
								---------</option>
							<option value="กรุงเทพมหานคร">กรุงเทพมหานคร</option>
							<option value="กระบี่">กระบี่</option>
							<option value="กาญจนบุรี">กาญจนบุรี</option>
							<option value="กาฬสินธุ์">กาฬสินธุ์</option>
							<option value="กำแพงเพชร">กำแพงเพชร</option>
							<option value="ขอนแก่น">ขอนแก่น</option>
							<option value="จันทบุรี">จันทบุรี</option>
							<option value="ฉะเชิงเทรา">ฉะเชิงเทรา</option>
							<option value="ชัยนาท">ชัยนาท</option>
							<option value="ชัยภูมิ">ชัยภูมิ</option>
							<option value="ชุมพร">ชุมพร</option>
							<option value="ชลบุรี">ชลบุรี</option>
							<option value="เชียงใหม่">เชียงใหม่</option>
							<option value="เชียงราย">เชียงราย</option>
							<option value="ตรัง">ตรัง</option>
							<option value="ตราด">ตราด</option>
							<option value="ตาก">ตาก</option>
							<option value="นครนายก">นครนายก</option>
							<option value="นครปฐม">นครปฐม</option>
							<option value="นครพนม">นครพนม</option>
							<option value="นครราชสีมา">นครราชสีมา</option>
							<option value="นครศรีธรรมราช">นครศรีธรรมราช</option>
							<option value="นครสวรรค์">นครสวรรค์</option>
							<option value="นราธิวาส">นราธิวาส</option>
							<option value="น่าน">น่าน</option>
							<option value="นนทบุรี">นนทบุรี</option>
							<option value="บึงกาฬ">บึงกาฬ</option>
							<option value="บุรีรัมย์">บุรีรัมย์</option>
							<option value="ประจวบคีรีขันธ์">ประจวบคีรีขันธ์</option>
							<option value="ปทุมธานี">ปทุมธานี</option>
							<option value="ปราจีนบุรี">ปราจีนบุรี</option>
							<option value="ปัตตานี">ปัตตานี</option>
							<option value="พะเยา">พะเยา</option>
							<option value="พระนครศรีอยุธยา">พระนครศรีอยุธยา</option>
							<option value="พังงา">พังงา</option>
							<option value="พิจิตร">พิจิตร</option>
							<option value="พิษณุโลก">พิษณุโลก</option>
							<option value="เพชรบุรี">เพชรบุรี</option>
							<option value="เพชรบูรณ์">เพชรบูรณ์</option>
							<option value="แพร่">แพร่</option>
							<option value="พัทลุง">พัทลุง</option>
							<option value="ภูเก็ต">ภูเก็ต</option>
							<option value="มหาสารคาม">มหาสารคาม</option>
							<option value="มุกดาหาร">มุกดาหาร</option>
							<option value="แม่ฮ่องสอน">แม่ฮ่องสอน</option>
							<option value="ยโสธร">ยโสธร</option>
							<option value="ยะลา">ยะลา</option>
							<option value="ร้อยเอ็ด">ร้อยเอ็ด</option>
							<option value="ระนอง">ระนอง</option>
							<option value="ระยอง">ระยอง</option>
							<option value="ราชบุรี">ราชบุรี</option>
							<option value="ลพบุรี">ลพบุรี</option>
							<option value="ลำปาง">ลำปาง</option>
							<option value="ลำพูน">ลำพูน</option>
							<option value="เลย">เลย</option>
							<option value="ศรีสะเกษ">ศรีสะเกษ</option>
							<option value="สกลนคร">สกลนคร</option>
							<option value="สงขลา">สงขลา</option>
							<option value="สมุทรสาคร">สมุทรสาคร</option>
							<option value="สมุทรปราการ">สมุทรปราการ</option>
							<option value="สมุทรสงคราม">สมุทรสงคราม</option>
							<option value="สระแก้ว">สระแก้ว</option>
							<option value="สระบุรี">สระบุรี</option>
							<option value="สิงห์บุรี">สิงห์บุรี</option>
							<option value="สุโขทัย">สุโขทัย</option>
							<option value="สุพรรณบุรี">สุพรรณบุรี</option>
							<option value="สุราษฎร์ธานี">สุราษฎร์ธานี</option>
							<option value="สุรินทร์">สุรินทร์</option>
							<option value="สตูล">สตูล</option>
							<option value="หนองคาย">หนองคาย</option>
							<option value="หนองบัวลำภู">หนองบัวลำภู</option>
							<option value="อำนาจเจริญ">อำนาจเจริญ</option>
							<option value="อุดรธานี">อุดรธานี</option>
							<option value="อุตรดิตถ์">อุตรดิตถ์</option>
							<option value="อุทัยธานี">อุทัยธานี</option>
							<option value="อุบลราชธานี">อุบลราชธานี</option>
							<option value="อ่างทอง">อ่างทอง</option>
							<option value="อื่นๆ">อื่นๆ</option>
						</select>

					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="background-color: white">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="btnSearch" type="submit" class="btn btn-search" >
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							ค้นหา
						</button>
					</div>
				</div>

			</td>
		</tr>
		</form>
	</table>

</body>
</html>