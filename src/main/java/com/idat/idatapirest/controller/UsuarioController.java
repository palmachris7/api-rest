package com.idat.idatapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.UsuarioResponseDTO;
import com.idat.idatapirest.dto.UsuarioRequestDTO;
import com.idat.idatapirest.security.JWTUserDetailService;
import com.idat.idatapirest.security.JWTTokenUtil;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    private JWTUserDetailService jWTUserDetailService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @RequestMapping(method = RequestMethod.POST, path = "/crearToken")
    public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO request){

        UserDetails userDetail = jWTUserDetailService.loadUserByUsername(request.getUsuario());

        return ResponseEntity.ok(new UsuarioResponseDTO(jwtTokenUtil.generateToken(userDetail.getUsername())));
    }


}