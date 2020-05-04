<?php
	include('koneksi.php');

	$nip = $_POST['nip'];
	$nama = $_POST['nama'];
	$email = $_POST['email'];
	$pass = $_POST['pass'];

	$sql = "INSERT INTO dosen (nip,nama,email,password) VALUES ('$nip','$nama','$email','$pass')";
	$query = mysqli_query($con,$sql);

	if($query){
		echo 'Berhasil Menambahkan';
	}else{
		echo 'Gagal Menambahkan';
	}

	mysqli_close($con);

?>