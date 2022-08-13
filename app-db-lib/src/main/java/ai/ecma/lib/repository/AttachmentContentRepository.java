package ai.ecma.lib.repository;

import ai.ecma.lib.entity.AttachmentContent;
import ai.ecma.lib.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

    Optional<AttachmentContent> findByAttachmentId(Long id);
}
