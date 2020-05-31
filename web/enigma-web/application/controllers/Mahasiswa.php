<?php

defined('BASEPATH') OR exit('no direct script access allowed');

class Mahasiswa extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("mahasiswa_model");
    }
    public function index()
    {
        $data["mahasiswas"] = $this->mahasiswa_model->getAll();
        $this->load->view("admin/mahasiswa/listMahasiswa", $data);
    }
    public function toadd()
    {
        $this->load->view("admin/mahasiswa/add_mahasiswa");
    }
    public function create()
    {
        $nim = $this->input->post('nim');
        $nama = $this->input->post('nama');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');

        $data = array(
            'nim' => $nim,
            'nama' => $nama,
            'email' => $email,
            'password' => $pass
        );

        $this->mahasiswa_model->create($data);
        redirect('mahasiswa');
    }
    public function toedit($id)
    {
        $where = array('id_mhs' => $id);
        $data['mhs'] = $this->mahasiswa_model->getMhs($where);
        $this->load->view("admin/mahasiswa/edit_mahasiswa",$data);
    }
    public function update()
    {
        $id_mhs = $this->input->post('id');
        $nim = $this->input->post('nim');
        $nama = $this->input->post('nama');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');

        $data = array(
            'nim' => $nim,
            'nama' => $nama,
            'email' => $email,
            'password' => $pass
        );

        $where = array(
            'id_mhs' => $id_mhs
        );

        $this->mahasiswa_model->update($where,$data);
        redirect('mahasiswa');
    }
    public function delete($id)
    {
        $where = array('id_mhs' => $id);
        $this->mahasiswa_model->delete($where);
        redirect('mahasiswa');
    }
}