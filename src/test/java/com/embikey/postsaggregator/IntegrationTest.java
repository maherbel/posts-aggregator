package com.embikey.postsaggregator;

import com.embikey.postsaggregator.PostsAggregatorApp;
import com.embikey.postsaggregator.config.AsyncSyncConfiguration;
import com.embikey.postsaggregator.config.EmbeddedKafka;
import com.embikey.postsaggregator.config.EmbeddedRedis;
import com.embikey.postsaggregator.config.EmbeddedSQL;
import com.embikey.postsaggregator.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { PostsAggregatorApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
