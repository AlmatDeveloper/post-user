package kz.dar.intership.summer.controller;

import kz.dar.intership.summer.entity.PostUser;
import kz.dar.intership.summer.model.PostUserDTO;
import kz.dar.intership.summer.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post-user")
public class PostUserController {

    @Autowired
    PostUserService postUserService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "post-user-api working";
    }

    @GetMapping("/{postUserId}")
    public ResponseEntity<PostUserDTO> getById(@PathVariable Long postUserId){
        return new ResponseEntity<>(postUserService.getById(postUserId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostUserDTO> getAll(){
        return postUserService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<PostUserDTO> create(@Valid @RequestBody PostUserDTO postUserDTO) {
        return new ResponseEntity<>(postUserService.create(postUserDTO), HttpStatus.OK);
    }

    @PostMapping("/update/{postUserId}")
    public ResponseEntity<PostUserDTO> update(@Valid @RequestBody PostUserDTO postUserDTO, @PathVariable Long postUserId) {
        return new ResponseEntity<>(postUserService.update(postUserDTO, postUserId), HttpStatus.OK);
    }
}
