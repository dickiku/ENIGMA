<?php 
 	
	include('koneksi.php');
	$id = $_GET['id'];
	
	//Membuat SQL Query
	$sql = "SELECT * FROM session INNER JOIN mahasiswa ON session.id_mhs = mahasiswa.nim";
	//$sql = "SELECT * FROM session";
	// $sql = "SELECT * FROM mahasiswa AS m INNER JOIN session AS s ON m.id_mhs = s.id_mhs";
	// $sql = "SELECT * FROM mahasiwa";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();

	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"nim"=>$row['nim'],
			"nama"=>$row['nama']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>