<?php 
 
	include('koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * FROM kelas";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();

	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"namakls"=>$row['nama_kelas'],
			"nokls"=>$row['no_kelas']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>