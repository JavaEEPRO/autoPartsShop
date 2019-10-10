package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel findByRoot(Root root);

    @Override
    void delete(Channel channel);

    @Override
    List<Channel> findAll(Sort sort);
}
