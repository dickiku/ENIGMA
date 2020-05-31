<?php

defined('BASEPATH') OR exit('no direct script access allowed');

class Dosen extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("dosen_model");
    }
    public function index()
    {
        $data["dosens"] = $this->dosen_model->getAll();
        $this->load->view("admin/dosen/listDosen", $data);
    }
    public function toadd()
    {
        $this->load->view("admin/dosen/add_dosen");
    }
    public function create()
    {
        $nip = $this->input->post('nip');
        $nama = $this->input->post('nama');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');

        $data = array(
            'nip' => $nip,
            'nama' => $nama,
            'email' => $email,
            'password' => $pass
        );

        $this->dosen_model->create($data);
        redirect('dosen');
    }
    public function toedit($id)
    {
        $where = array('id_dsn' => $id);
        $data['dosen'] = $this->dosen_model->getDsn($where);
        $this->load->view("admin/dosen/edit_dosen",$data);
    }
    public function update()
    {
        $id_dsn = $this->input->post('id');
        $nip = $this->input->post('nip');
        $nama = $this->input->post('nama');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');

        $data = array(
            'nip' => $nip,
            'nama' => $nama,
            'email' => $email,
            'password' => $pass
        );

        $where = array(
            'id_dsn' => $id_dsn
        );

        $this->dosen_model->update($where,$data);
        redirect('dosen');
    }
    public function delete($id)
    {
        $where = array('id_dsn' => $id);
        $this->dosen_model->delete($where);
        redirect('dosen');
    }
}