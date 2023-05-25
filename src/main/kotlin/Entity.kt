import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.World
import functions.createWall

class Entity(private val texture: Texture,
             private val body: Body,
             private val speed: Float = 50f) {

    fun renderWalls(spriteBatch: SpriteBatch){
        val wh = 5f
        val xy = 1.5f
        val x = body.position.x
        val y = body.position.y
        spriteBatch.draw(texture, x-xy, y-xy, wh, wh)
    }
    fun renderPlayer(spriteBatch: SpriteBatch){
        val wh = 4f
        val xy = 1f
        val x = body.position.x
        val y = body.position.y
        spriteBatch.draw(texture, x-xy, y-xy, wh, wh)
    }
    fun renderEnemy(spriteBatch: SpriteBatch){
        val wh = 3f
        val xy = 0.5f
        val x = body.position.x
        val y = body.position.y
        spriteBatch.draw(texture, x-xy, y-xy, wh, wh)
    }
    fun getPosition(): Vector2 = Vector2(body.position.x + 1f, body.position.y + 1f)
    fun getBody(): Body = body
    fun applyForceToCenter(force: Vector2) {
        body.applyForceToCenter(force, true)
    }
    fun moveAt(position: Vector2) {
        val v = Vector2(position.x - body.position.x, position.y - body.position.y)
        v.nor()
        v.scl(speed)
        applyForceToCenter(v)
    }
}