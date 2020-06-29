<?php 
 
	require_once('koneksi.php');
	
	//Membuat SQL Query
	//$sql = "SELECT * FROM session";
	$sql = SELECT * FROM mahasiswa AS m INNER JOIN session AS s ON m.id_mhs = s.id_mhs;
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"nim"=>$row['nim'],
			"name"=>$row['nama']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>