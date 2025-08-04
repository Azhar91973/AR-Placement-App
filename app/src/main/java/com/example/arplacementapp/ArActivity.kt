package com.example.arplacementapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.Color
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ArActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var drillPlaced = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        arFragment = supportFragmentManager.findFragmentById(R.id.ar_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            if (drillPlaced) return@setOnTapArPlaneListener

            val anchor = hitResult.createAnchor()
            MaterialFactory.makeOpaqueWithColor(this, Color(android.graphics.Color.RED))
                .thenAccept { material ->
                    val cube = ShapeFactory.makeCube(
                        Vector3(0.1f, 0.1f, 0.1f), Vector3(0f, 0.05f, 0f), material
                    )

                    val anchorNode = AnchorNode(anchor)
                    anchorNode.setParent(arFragment.arSceneView.scene)

                    val node = TransformableNode(arFragment.transformationSystem)
                    node.renderable = cube
                    node.setParent(anchorNode)
                    node.select()

                    drillPlaced = true
                }
        }
    }
}
