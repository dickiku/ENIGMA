<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Login_model extends CI_Model
{
    private $_table = "admin";

    public function cek_login($where)
    {
        return $this->db->get_where($this->_table,$where)->num_rows();
    }
}