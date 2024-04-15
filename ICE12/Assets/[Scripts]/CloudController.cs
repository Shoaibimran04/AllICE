using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CloudController : MonoBehaviour
{
    public float verticalSpeed;
    public float horizontalSpeed;
    public float topBound;
    public float bottomBound;
    public float leftBound;
    public float rightBound;

    // Start is called before the first frame update
    void Start()
    {
        ResetGameObject();
    }

    // Update is called once per frame
    void Update()
    {
        Move();
        CheckBounds();
    }

    void Move()
    {
        transform.position -= new Vector3(horizontalSpeed * Time.deltaTime, verticalSpeed * Time.deltaTime, 0);
    }

    void ResetGameObject()
    {
        var randomX = Random.Range(leftBound, rightBound);
        verticalSpeed = Random.Range(5.0f, 10.0f);
        horizontalSpeed = Random.Range(-2.0f, 2.0f); // Horizontal drift
        transform.position = new Vector3(randomX, topBound, 0);
    }

    void CheckBounds()
    {
        if (transform.position.y <= bottomBound)
        {
            ResetGameObject();
        }
    }
}
