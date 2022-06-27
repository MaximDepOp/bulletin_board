import React, { useEffect, useState } from "react";

import styles from "./Recommendation.module.scss";

import sale1 from "@assets/sale1.png";
import sale2 from "@assets/sale2.png";
import { Link } from "react-router-dom";
import axios from "axios";
import Card from "@components/Card";
import Spinner from "../../components/Spinner";

const Recommendation = () => {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const [error, setError] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);
      setError(false);
      try {
        const res = await axios
          .get("https://62b35368a36f3a973d203d1e.mockapi.io/api/v1/cards")
          .then((res) => {
            setData(res.data);
            setIsLoading(false);
          });
      } catch (error) {
        setError(true);
      }
      setIsLoading(false);
    };
    fetchData();
  }, []);

  if (isLoading) return <Spinner />;
  if (error) <p>Something went wrong.</p>;

  return (
    <>
      <h1 className={styles.title}>Рекомендации для вас</h1>
      <div className={styles.recommendation}>
        {data.map((card) => (
          <Link to={`/ad/${card.id}`} state={card}>
            <Card {...card} key={card.id} />
          </Link>
        ))}
      </div>
    </>
  );
};

export default Recommendation;
