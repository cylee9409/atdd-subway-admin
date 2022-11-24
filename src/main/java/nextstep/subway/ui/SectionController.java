package nextstep.subway.ui;

import nextstep.subway.application.SectionService;
import nextstep.subway.dto.SectionRequest;
import nextstep.subway.dto.SectionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lines/{lineId}")
public class SectionController {

    private SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/sections")
    public ResponseEntity<List<SectionResponse>> addSection(@PathVariable Long lineId, @RequestBody SectionRequest sectionRequest) {
        List<SectionResponse> sectionResponse = sectionService.saveSection(lineId, sectionRequest);
        return ResponseEntity.created(URI.create("/lines/" + lineId + "/sections")).body(sectionResponse);
    }

}
