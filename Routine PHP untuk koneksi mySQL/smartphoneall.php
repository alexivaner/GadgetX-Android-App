<?php 
 
 /*
Ivan Surya H
 */
 
	//Inisiasi koneksi menggunakan file koneksi.php
	require_once('koneksi.php');
	
	//Membuat SQL Query untuk memilih tabel yang ingin digunakan
	$sql = "SELECT * FROM tb_smartphone";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['id'],
			"brand"=>$row['BRAND'],
			"name"=>$row['NAME'],
			"stat"=>$row['STATUS']

		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>