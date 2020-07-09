<?php 
 	
	//$id = $_GET['id'];

	include('koneksi.php');
	// $id = '2';
	
	//Membuat SQL Query
	$sql = "SELECT * FROM session INNER JOIN mahasiswa ON session.id_mhs = mahasiswa.nim";
	//$sql = "SELECT * FROM session INNER JOIN mahasiswa ON session.id_mhs = mahasiswa.nim WHERE id_kelas = '$id' ";
	//$sql = "SELECT * FROM session";
	// $sql = "SELECT * FROM mahasiswa AS m INNER JOIN session AS s ON m.id_mhs = s.id_mhs";
	// $sql = "SELECT * FROM mahasiwa";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();

	while($row = mysqli_fetch_array($r)){
		
		array_push($result,array(
			"nim"=>$row['nim'],
			"nama"=>$row['nama']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>