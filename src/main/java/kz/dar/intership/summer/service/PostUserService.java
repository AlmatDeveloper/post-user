package kz.dar.intership.summer.service;

import kz.dar.intership.summer.model.PostUserDTO;

import java.util.List;

public interface PostUserService {
    PostUserDTO getById(Long id);
    List<PostUserDTO> getAll();
    PostUserDTO create(PostUserDTO postUserDTO);
    PostUserDTO update(PostUserDTO postUserDTO, Long postUserId);
}
