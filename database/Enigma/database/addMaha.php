<?php
	include('koneksi.php');

	$nim = $_POST['nim'];
	$nama = $_POST['nama'];
	$email = $_POST['email'];
	$pass = $_POST['pass'];

	$sql = "INSERT INTO mahasiswa (nim,nama,email,password) VALUES ('$nim','$nama','$email','$pass')";
	$query = mysqli_query($con,$sql);

	if($query){
		echo 'Berhasil Menambahkan';
	}else{
		echo 'Gagal Menambahkan';
	}

	mysqli_close($con);

?>