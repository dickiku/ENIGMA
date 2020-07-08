<?php
	include('koneksi.php');

	$nip = $_POST['nip'];
	$nim = $_POST['nim'];
	$kls = $_POST['idkls'];

    // $Sql_Query = "SELECT id_mhs FROM mahasiswa WHERE email = '$nim'";
    // $idMaha= mysqli_query($con,$Sql_Query);

    // $Sql_Query = "SELECT id_dsn FROM WHERE email = '$nip'";
    // $idDsn= mysqli_query($con,$Sql_Query);

    $sqls = "INSERT INTO session (id_mhs,id_dsn,waktu,id_kelas) VALUES ( '$nim', '$nip',now(),kls)";
	$querys = mysqli_query($con,$sqls);

	$sql = "INSERT INTO kehadiran (id_mhs,id_dsn,waktu,id_kelas) VALUES ( '$nim', '$nip',now(),kls)";
	$query = mysqli_query($con,$sql);

	if($query){
		echo 'Berhasil Menambahkan';
	}else{
		echo 'Gagal Menambahkan';
	}

	mysqli_close($con);

?>