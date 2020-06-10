<?php

    include('koneksi.php');
    $nim = $_POST['nim'];
    $password = $_POST['pass'];

    $Sql_Query = "SELECT * FROM mahasiswa WHERE nim = '$nim' and password = '$password' ";

    $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

    if(isset($check)){

     echo "Data Matched";
    }
    else{
     echo "Invalid Username or Password Please Try Again";
    }
    mysqli_close($con);

?>