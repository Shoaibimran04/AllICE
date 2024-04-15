using System.Collections;
using UnityEngine;

public class CloudController : MonoBehaviour
{
    public float verticalSpeed;
    public float horizontalDrift;
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
        // Move the cloud downwards
        transform.position -= new Vector3(0, verticalSpeed, 0) * Time.deltaTime;

        // Drift the cloud horizontally
        transform.position -= new Vector3(horizontalDrift, 0, 0) * Time.deltaTime;
    }

    void ResetGameObject()
    {
        // Start the cloud in a random horizontal position above the camera view
        float randomX = Random.Range(leftBound, rightBound);
        float randomY = topBound;
        transform.position = new Vector3(randomX, randomY, 0);
        
        // Add a random vertical speed
        verticalSpeed = Random.Range(1f, 3f);
        
        // Add a random horizontal drift
        horizontalDrift = Random.Range(-1f, 1f);
    }

    void CheckBounds()
    {
        // Reset the cloud's position when it goes below the bottom bound
        if (transform.position.y <= bottomBound)
        {
            ResetGameObject();
        }
    }
}
