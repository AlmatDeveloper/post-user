package kz.dar.intership.summer.service.impl;

import kz.dar.intership.summer.entity.PostUser;
import kz.dar.intership.summer.model.PostUserDTO;
import kz.dar.intership.summer.repository.PostUserRepository;
import kz.dar.intership.summer.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostUserServiceImpl implements PostUserService {

    @Autowired
    private PostUserRepository postUserRepository;

    @Override
    public PostUserDTO getById(Long id) {
        PostUser postUser = postUserRepository.findById(id).get();

        return new PostUserDTO(postUser.getId(),
                postUser.getLastName(),
                postUser.getFirstName(),
                postUser.getEmail());
    }

    @Override
    public PostUserDTO create(PostUserDTO postUserDTO) {
        PostUser postUser = new PostUser();

        postUser.setEmail(postUserDTO.getEmail());
        postUser.setFirstName(postUserDTO.getFirstName());
        postUser.setLastName(postUserDTO.getLastName());

        System.out.println(postUserDTO);
        System.out.println(postUser);
        postUserRepository.save(postUser);

        postUserDTO.setId(postUser.getId());

        return postUserDTO;
    }

    @Override
    public PostUserDTO update(PostUserDTO postUserDTO, Long postUserId) {
        PostUser postUser = postUserRepository.findById(postUserId).get();

        System.out.println(postUserDTO);

        postUser.setEmail(postUserDTO.getEmail());
        postUser.setFirstName(postUserDTO.getFirstName());
        postUser.setLastName(postUserDTO.getLastName());

        System.out.println(postUser);

        postUserRepository.save(postUser);
        postUserDTO.setId(postUser.getId());

        return postUserDTO;
    }

    @Override
    public List<PostUserDTO> getAll() {
        return postUserRepository.findAll().stream().map(m -> new PostUserDTO(
                m.getId(),
                m.getLastName(),
                m.getFirstName(),
                m.getEmail())).collect(Collectors.toList());
    }
}
