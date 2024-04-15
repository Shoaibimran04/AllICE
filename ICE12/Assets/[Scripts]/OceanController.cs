using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OceanController : MonoBehaviour
{
    public float verticalSpeed;
    public float topBound;
    public float bottomBound;

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
        transform.position -= new Vector3(0, verticalSpeed * Time.deltaTime, 0);
    }

    void ResetGameObject()
    {
        transform.position = new Vector3(0, topBound, 0);
    }

    void CheckBounds()
    {
        if (transform.position.y <= bottomBound)
        {
            ResetGameObject();
        }
    }
    
}
