package com.example.casestudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void betriebsstelleTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/aamp", String.class))
                .contains("{\"name\":\"Hamburg Anckelmannsplatz\",\"kurzname\":\"Anckelmannsplatz\",\"typ\":\"Üst\"}");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/fd", String.class))
                .contains("{\"name\":\"Darmstadt Hbf\",\"kurzname\":\"Darmstadt Hbf\",\"typ\":\"Bf\"}");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/fdal", String.class))
                .contains("{\"name\":\"Darmstadt Lichtwiese\",\"kurzname\":\"Da Lichtwiese\",\"typ\":\"Hp\"}");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/fbzm", String.class))
                .contains("{\"name\":\"Frankfurt Betriebszentrale RB Mitte\",\"kurzname\":\"Frankfurt BZ Mit\",\"typ\":\"BZ N\"}");
    }

    @Test
    public void betriebsstelleNotFoundTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/ammp", String.class))
                .contains("Betriebsstelle ammp konnte nicht gefunden werden.");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/dkls8", String.class))
                .contains("Betriebsstelle dkls8 konnte nicht gefunden werden.");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/betriebsstelle/hppl", String.class))
                .contains("Betriebsstelle hppl konnte nicht gefunden werden.");
    }



}
