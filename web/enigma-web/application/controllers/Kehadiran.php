<?php

defined('BASEPATH') OR exit('no direct script access allowed');

class Kehadiran extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("kehadiran_model");
    }

    public function index()
    {
        $data["kehadiran"] = $this->kehadiran_model->getAll();
        $this->load->view("admin/kehadiran/listKehadiran", $data);
    }

    public function session()
    {
        $data["session"] = $this->kehadiran_model->getSession();
        $this->load->view("admin/kehadiran/listSession",$data);
    }

    public function delSes()
    {
        $this->kehadiran_model->delAllSes();
        redirect('kehadiran/session');
    }
}