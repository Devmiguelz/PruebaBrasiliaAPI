package api.prueba.brasilia.mapper;

import api.prueba.brasilia.dto.tarea.TareaCrearDto;
import api.prueba.brasilia.dto.tarea.TareaListarDto;
import api.prueba.brasilia.entity.Tarea;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TareaMapper {

    private final ModelMapper modelMapper;

    public TareaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Tarea ToEntidad(TareaCrearDto tareaCrearDto) {
        return modelMapper.map(tareaCrearDto, Tarea.class);
    }

    public TareaListarDto ToDto(Tarea tarea) {
        return modelMapper.map(tarea, TareaListarDto.class);
    }

    public List<TareaListarDto> ToDtoList(List<Tarea> usuarioList) {
        return usuarioList.stream()
                .map(this::ToDto)
                .collect(Collectors.toList());
    }
}
