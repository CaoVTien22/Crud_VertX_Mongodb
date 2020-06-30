import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class Launcher extends AbstractVerticle {
    @Override
    public void start(Future future) throws Exception {
        vertx
                .createHttpServer()
                .requestHandler(request -> {
                    request.response().end("<h1> Hello World <h1>");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) future.complete();
                    else future.fail(result.cause());
                });
    }
}
