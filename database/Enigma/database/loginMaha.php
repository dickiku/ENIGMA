<?php

    include('koneksi.php');
    $email = $_POST['email'];
    $password = $_POST['pass'];

    $Sql_Query = "SELECT * FROM mahasiswa WHERE email = '$email' and password = '$password' ";

    $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

    if(isset($check)){

     echo "Data Matched";
    }
    else{
     echo "Invalid Username or Password Please Try Again";
    }
    mysqli_close($con);

?>