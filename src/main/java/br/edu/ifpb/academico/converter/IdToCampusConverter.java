package br.edu.ifpb.academico.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import br.edu.ifpb.academico.entity.Campus;
import br.edu.ifpb.academico.service.CampusService;

@Component
public class IdToCampusConverter implements Converter<String, Campus> {
   private final CampusService campusService;
   public IdToCampusConverter(CampusService campusService) {
       this.campusService = campusService;
   }
   @Override
   public Campus convert(String source) {
       return (source == null || source.isBlank()) ? null
               : campusService.findById(Long.valueOf(source));
   }
}

