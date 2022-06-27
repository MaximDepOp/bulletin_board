import React from "react";

import styles from "./Card.module.scss";

const Card = ({ id, imageUrl, name }) => {
  return (
    <div className={styles.card} key={id}>
      <img src={imageUrl} alt="" />
      <div className={styles.info}>
        <h2>{name}</h2>
        <svg
          width="18"
          height="16"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            fillRule="evenodd"
            clipRule="evenodd"
            d="M8.293 15.707a1 1 0 001.414 0l6.8-6.8C17.394 8.02 18 6.666 18 5.2 18 2.348 15.652 0 12.8 0c-1.476 0-2.795.615-3.77 1.612L9 1.581l-.03.031C7.996.615 6.676 0 5.2 0 2.348 0 0 2.348 0 5.2c0 1.466.606 2.82 1.493 3.707l6.8 6.8zM9 4.3a1 1 0 01-.868-.504C7.49 2.672 6.402 2 5.2 2 3.452 2 2 3.452 2 5.2c0 .934.394 1.78.907 2.293L9 13.586l6.093-6.093C15.606 6.98 16 6.134 16 5.2 16 3.452 14.548 2 12.8 2c-1.202 0-2.29.672-2.932 1.796A1 1 0 019 4.3z"
            fill="#0AF"
          />
        </svg>
      </div>
      <p>пос. Лесной</p>
      <p>31 мая 16:10</p>
    </div>
  );
};

export default Card;
