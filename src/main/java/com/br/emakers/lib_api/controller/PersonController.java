package com.br.emakers.lib_api.controller;

import com.br.emakers.lib_api.data.dto.request.PersonRequestDTO;
import com.br.emakers.lib_api.data.dto.response.PersonResponseDTO;
import com.br.emakers.lib_api.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Person", description = "Endpoints for person management")
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Get all persons", description = "Returns a list of all registered persons",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<PersonResponseDTO>> getAllPersons(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @Operation(summary = "Get person by ID", description = "Returns a single person by their ID",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping(value = "/{personId}", produces = "application/json")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable Long personId){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(personId));
    }

    @Operation(summary = "Register a new person", description = "Creates and saves a new person in the database",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201",
                            content = @Content(schema = @Schema(implementation = PersonResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PersonResponseDTO> registerPerson(@Valid @RequestBody PersonRequestDTO personRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.registerPerson(personRequestDTO));
    }

    @Operation(summary = "Update a person", description = "Updates the data of an existing person by their ID",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @PutMapping(value = "/update/{personId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable Long personId, @Valid @RequestBody PersonRequestDTO personRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(personId, personRequestDTO));
    }

    @Operation(summary = "Delete a person", description = "Deletes a person from the database by their ID",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @DeleteMapping(value = "/delete/{personId}", produces = "application/json")
    public ResponseEntity<String> deletePerson(@PathVariable Long personId){
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(personId));
    }
}