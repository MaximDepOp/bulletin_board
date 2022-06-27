import React from "react";
import styles from "./Advt.module.scss";
import logo from "@assets/logo.svg";
import { Link } from "react-router-dom";
const info = ["О компании", "Работа", "Контакты", "Еще"];

const Advt = () => {
  return (
    <div className={styles.bot}>
      <div className="container">
        <nav className={styles.avito}>
          <Link to="/">
            <img src={logo} alt="" />
          </Link>
          <ul>
            {info.map((item, index) => (
              <li key={index}>
                <a href="/#">{item}</a>
              </li>
            ))}
          </ul>
        </nav>
      </div>
    </div>
  );
};

export default Advt;
