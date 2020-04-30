<?php

$host = 'localhost'; 
$username = 'root'; 
$pwd = ''; 
$db = 'gadgetx';

$con = mysqli_connect($host, $username, $pwd, $db) or die('Unable to Connect');
	$memory = $_GET["memory"];	
	
if(mysqli_connect_error($con)) 
	{
		echo "Failed to Connect to Database".mysqli_connect_error();
	}
	
	$sql = "SELECT * FROM tb_smartphone WHERE MEMORY LIKE '%$memory GB RAM%'";
	$result = mysqli_query($con, $sql);
	if($result)
			{ 
				while($row = mysqli_fetch_array($result)) 
				{ 
					$flag[] = $row; 
				} 
			
			print(json_encode($flag));
			} 
			
			mysqli_close($con); ?>﻿