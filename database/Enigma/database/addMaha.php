<?php
	include('koneksi.php');

	$nim = $_POST['nim'];
	$nama = $_POST['nama'];
	$email = $_POST['email'];
	$pass = $_POST['pass'];

	$sql = "INSERT INTO mahasiswa (nim,nama,email,password) VALUES ('$nim','$nama','$email','$pass')";
	$query = mysqli_query($con,$sql);

	if($query){
		include "phpqrcode/qrlib.php"; 

		$tempdir = "temp/";
		if (!file_exists($tempdir))
		mkdir($tempdir);

		$codeContents = $nim;
		$namaFile=$nim.".png";
		$level=QR_ECLEVEL_H;
		$UkuranPixel=10;
		$UkuranFrame=4;

		QRcode::png($codeContents, $tempdir.$namaFile, $level, $UkuranPixel, $UkuranFrame); 

		echo 'Berhasil Menambahkan';
	}else{
		echo 'Gagal Menambahkan';
	}

	mysqli_close($con);

?>