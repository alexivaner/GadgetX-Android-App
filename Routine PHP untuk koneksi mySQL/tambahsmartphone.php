
<?php
 
 /*
Ivan Surya H
Routine PHP untuk menambahkan data ke database
 */
 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$name = $_POST['name'];
		$network = $_POST['network'];
		$stat = $_POST['stat'];
		$dim = $_POST['dim'];
		$disty = $_POST['disty'];
		$disz = $_POST['disz'];
		$cpu = $_POST['cpu'];
		$os = $_POST['os'];
		$memory = $_POST['memory'];
		$camera = $_POST['camera'];
		$batt = $_POST['batt'];
		$brand = $_POST['brand'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_smartphone (NAME,NETWORK,STATUS,DIMENSION,
		DISPLAY_TYPE,DISPLAY_SIZE,CPU,OS,MEMORY,CAMERA,BATTERY,BRAND) 
		VALUES ('$name','$network','$stat','$dim','$disty','$disz','$cpu'
		,'$os','$memory','$camera','$batt','$brand')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Data Smartphone';
		}else{
			echo 'Gagal Menambahkan Data Smartphone';
		}
		
		mysqli_close($con);
	}
?>