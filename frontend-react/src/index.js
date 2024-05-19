import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import i18n from './i18n';
import {I18nextProvider} from "react-i18next";
import LanguageSwitcher from "./components/LanguageSwitcher";

i18n.changeLanguage('en');
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <I18nextProvider i18n={i18n}>
          <LanguageSwitcher />
          <App />
      </I18nextProvider>
  </React.StrictMode>
);
