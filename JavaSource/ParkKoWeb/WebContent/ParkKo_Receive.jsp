<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Park-Ko Recieve</title>

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
</head>

<body role="document">

	<div class="col-md-offset-2">
		
	
		<div class="row">
			<label for="lbProvince" class="col-sm-2 control-label">จังหวัด</label>
			<p id="lbProvince" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>

		</div>
		
		<div class="row">
			<label for="lbEntrytime" class="col-sm-2 control-label">วันเวลาเข้า</label>
			<p id="lbEntrytime" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>

		</div>
		
		<div class="row">
			<label for="lbExittime" class="col-sm-2 control-label">วันเวลาออก</label>
			<p id="lbExittime" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>
			
		</div>
		
		<div class="row">
			<label for="lbTotaltime" class="col-sm-2 control-label">เวลาทั้งหมด</label>
			<p id="lbTotaltime" type="text" class="col-sm-1 control-label" placeholder="" disabled> </p>
			<label class="col-sm-1 control-label">ชั่วโมง</label>
		</div>

		<div class="row">
			<label for="lbTotaltime" class="col-sm-1 control-label">รับเงิน</label>
			<input id="txtRecAmt" type="text" class="col-sm-1 control-label" placeholder=""> 
			<label class="col-sm-1 control-label">บาท</label>
			<button type="submit" class="btn btn-primary">รับเงิน</button>

		</div>
	</div>

<table class="table table-striped">
<tr>
	<td>
		<div class="form-group">
		<img src="" alt="" class="img-rounded"></img>
		</div>
	</td>
	<td>
		<label class="col-sm-8 control-label">สวัสดี</label>
	</td>
</tr>
	
 <tr>
	<td>
		
	</td>
	
	<td>
		<label for="lbname" class="col-sm-1 control-label">ชื่อ</label>
		<p id="lbname" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>
		<label for="lbsurname" class="col-sm-1 control-label">นามสกุล</label> 
		<p id="lbsurname" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>
	</td>
</tr>

<tr>
	<td>
		
	</td>
	<td>
		<label for="lbCarID" class="col-sm-2 control-label">ทะเบียนรถ</label>
		<p id="lbCarID" type="text" class="col-sm-2 control-label" placeholder="" disabled> </p>
	</td>
</tr>
</table>

</body>
</html>
