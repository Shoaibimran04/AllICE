using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerBehaviour : MonoBehaviour
{
    public AudioSource thunderSound;
    public AudioSource yaySound;

    // Start is called before the first frame update
    void Start()
    {
        thunderSound = GetComponents<AudioSource>()[0];
        yaySound = GetComponents<AudioSource>()[1];
    }

    // Update is called once per frame
    void Update()
    {
        Move();
    }

    void Move()
    {
        if (Input.touchCount > 0)
        {
            Touch touch = Input.GetTouch(0);

            // translating from screen space to world space
            Vector3 touchPosition = Camera.main.ScreenToWorldPoint(touch.position);
            touchPosition.z = 0;
            touchPosition.y = -4.0f;
            transform.position = touchPosition;
        }
    }

       void OnTriggerEnter2D(Collider2D other)
    {
        switch (other.gameObject.tag)
        {
            case "Island":
                yaySound.Play();
                break;
            case "Cloud":
                thunderSound.Play();
                break;
        }
    }   
}
