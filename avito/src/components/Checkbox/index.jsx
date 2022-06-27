import React from "react";

import styles from "./Checkbox.module.scss";

export const Checkbox = ({ children }) => {
  return (
    <>
      <input type="checkbox" />
      {children}
    </>
  );
};
