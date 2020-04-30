
<?php 
 
 /*
 
Ivan Surya H
 */
	
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM tb_pegawai WHERE id=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"name"=>$row['NAME'],
			"network"=>$row['NETWORK'],
			"stat"=>$row['STATUS'],
			"dim"=>$row['DIMENSION'],
			"disty"=>$row['DISPLAY_TYPE'],
			"disz"=>$row['DISPLAY_SIZE'],
			"cpu"=>$row['CPU'],
			"os"=>$row['OS'],
			"memory"=>$row['MEMORY'],
			"camera"=>$row['CAMERA'],
			"batt"=>$row['BATTERY'],
			"brand"=>$row['BRAND'],
		));
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>