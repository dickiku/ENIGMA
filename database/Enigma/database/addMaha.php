<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$nim = $_POST['nim'];
		$nama = $_POST['nama'];
		$email = $_POST['email'];
		$pass = $_POST['pass'];
		
		$sql = "INSERT INTO mahasiswa (nim,nama,email,password) VALUES ('$nim','$nama','$email','$pass')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan';
		}else{
			echo 'Gagal Menambahkan';
		}
		
		mysqli_close($con);
	}
?>