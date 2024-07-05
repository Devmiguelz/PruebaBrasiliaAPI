package api.prueba.brasilia.dto.mapper;

import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario ToEntidad(UsuarioCrearDto usuarioCrearDto) {
        return modelMapper.map(usuarioCrearDto, Usuario.class);
    }

    public UsuarioListarDto ToDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioListarDto.class);
    }

    public List<UsuarioListarDto> ToDtoList(List<Usuario> usuarioList) {
        return usuarioList.stream()
                .map(this::ToDto)
                .collect(Collectors.toList());
    }
}
