package kz.kegoc.bln.webapi.dict;

import java.util.*;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.dozer.DozerBeanMapper;
import kz.kegoc.bln.entity.dict.AccountingType;
import kz.kegoc.bln.entity.dict.dto.AccountingTypeDto;
import kz.kegoc.bln.repository.common.query.*;
import kz.kegoc.bln.service.dict.AccountingTypeService;

import static org.apache.commons.lang3.StringUtils.*;

@Stateless
@Path("/dict/dictAccountingType")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class AccountingTypeResourceImpl {

	@GET 
	public Response getAll(@QueryParam("code") String code, @QueryParam("name") String name) {		
		Query query = QueryImpl.builder()			
			.setParameter("code", isNotEmpty(code) ? new MyQueryParam("code", code + "%", ConditionType.LIKE) : null)
			.setParameter("name", isNotEmpty(name) ? new MyQueryParam("name", name + "%", ConditionType.LIKE) : null)
			.setOrderBy("t.id")
			.build();		
		
		List<AccountingTypeDto> list = service.find(query)
			.stream()
			.map( it-> mapper.map(it, AccountingTypeDto.class) )
			.collect(Collectors.toList());
		
		return Response.ok()
				.entity(new GenericEntity<Collection<AccountingTypeDto>>(list){})
				.build();
	}
	
	
	@GET 
	@Path("/{id : \\d+}") 
	public Response getById(@PathParam("id") Long id) {
		AccountingType entity = service.findById(id);
		return Response.ok()
			.entity(mapper.map(entity, AccountingTypeDto.class))
			.build();		
	}
	

	@GET
	@Path("/byCode/{code}")
	public Response getByCode(@PathParam("code") String code) {		
		AccountingType entity = service.findByCode(code);
		return Response.ok()
			.entity(mapper.map(entity, AccountingTypeDto.class))
			.build();
	}
	
	
	@GET
	@Path("/byName/{name}")
	public Response getByName(@PathParam("name") String name) {		
		AccountingType entity = service.findByName(name);
		return Response.ok()
			.entity(mapper.map(entity, AccountingTypeDto.class))
			.build();
	}

	
	@POST
	public Response create(AccountingTypeDto accountingTypeDto) {
		AccountingType newEntity = service.create(mapper.map(accountingTypeDto, AccountingType.class));	
		return Response.ok()
			.entity(mapper.map(newEntity, AccountingTypeDto.class))
			.build();
	}
	
	
	@PUT 
	@Path("{id : \\d+}") 
	public Response update(@PathParam("id") Long id, AccountingTypeDto accountingTypeDto ) {
		AccountingType newEntity = service.update(mapper.map(accountingTypeDto, AccountingType.class)); 
		return Response.ok()
			.entity(mapper.map(newEntity, AccountingTypeDto.class))
			.build();
	}
	
	
	@DELETE 
	@Path("{id : \\d+}") 
	public Response delete(@PathParam("id") Long id) {
		service.delete(id);		
		return Response.noContent()
			.build();
	}
	

	@Inject
	private AccountingTypeService service;

	@Inject
	private DozerBeanMapper mapper;

	@Context
	private SecurityContext context;
}
